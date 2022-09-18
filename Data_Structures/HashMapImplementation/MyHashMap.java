package HashMapImplementation;

import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("rawtypes")
public class MyHashMap<K,V> implements Iterable <HashMapImplementation.MyHashMap.HashMapNode> {
	
	public  class HashMapNode{
		K key;
		V value;
		
		HashMapNode(K key,V value){
			this.key = key;
			this.value = value;
		}	
	}
	
	private int size;
	private LinkedList<HashMapNode>[] buckets;
	
	public MyHashMap(int capacity) {
		initializeBuckets(capacity);
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void initializeBuckets(int length) {
		buckets = new LinkedList[length];
		for(int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
		
	}
	
	public void insert(K key,V value) {
		if(size == buckets.length) {
			System.out.println("there is no place in the map to enter a new entry");
			return;
			
		}
		
		int bucket_index = hashfunction(key);
		int data_index = findWithInBucket(key,bucket_index);
		if(data_index == -1) {//denotes key doesn't exist in the map
			buckets[bucket_index].add(new HashMapNode(key,value));
			size++;
		}else {
			buckets[bucket_index].get(data_index).value = value;
		}
		//this thing will help us distributing data uniformly and reduce chances of collision
		double lambda = (double)size/(double)buckets.length;
		if(lambda > 2.0) {
			resize();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void resize() {
		LinkedList<HashMapNode>[] arr = buckets;
		buckets = new LinkedList[2*arr.length];
		for(int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}
		
		size = 0;
		for(int j = 0; j < arr.length; j++) {
			LinkedList<HashMapNode> my_list = arr[j];
			for(int k = 0; k < my_list.size(); k++) {
				insert(my_list.get(k).key,my_list.get(k).value);
			}
		}
	}
	//this function will help calculating bucket index
	public int hashfunction(K key) {
		return Math.abs(key.hashCode())%buckets.length;
	}
	
	//this function will help calculating data index
	public int findWithInBucket(K key,int bucket_index) {
		for(int i = 0; i < buckets[bucket_index].size(); i++) {
			if(buckets[bucket_index].get(i).key.equals(key)) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	public V GetValueByKey(K key) {
		if(size == 0) {
			System.out.println("there is nothing to get from the map");
			return null;
		}
		
		int bucket_index = hashfunction(key);
		int data_index = findWithInBucket(key,bucket_index);
		//this if block denotes key is not present in the map
		if(data_index == -1) {
			return null;
		}else {
			return buckets[bucket_index].get(data_index).value;
		}
		
	}
	
	public boolean containsKey(K key) {
		if(size == 0) {
			return false;
		}
		int bucket_index = hashfunction(key);
		int data_index = findWithInBucket(key,bucket_index);
		//this if block denotes key is not present in the map
		if(data_index == -1) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public V Delete(K key) {
		if(size == 0) {
			System.out.println("there is no entry present in the map to delete");
			return null;
		}
		int bucket_index = hashfunction(key);
		int data_index = findWithInBucket(key,bucket_index);
		//this if block denotes key is not present in the map
		if(data_index == -1) {
			return null;
		}else {
			V removed_value = buckets[bucket_index].get(data_index).value;
			buckets[bucket_index].remove(data_index);
			size--;
			return removed_value;
		}	
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		if(size == 0) {
			System.out.println("Nothing to print the map");
			return;
		}
		
		for(int i = 0; i < buckets.length; i++) {
			System.out.print("Map elements are :- ");
			for(HashMapNode node : buckets[i]) {
				System.out.print(node.key + "-" + node.value + " ");
			}
			System.out.println();
		}
	}
	
	
	@Override
	public Iterator<MyHashMap.HashMapNode> iterator() {
	    final Iterator<MyHashMap.HashMapNode> it = new Iterator<>() {

	        private int currentListIndex = 0;
	        private int currentListSize = MyHashMap.this.buckets[this.currentListIndex].size();
	        private int bucketIndex = 0;
	        int tempSize = 0;
	        @Override
	        public boolean hasNext() {
	            // System.out.println("tempSize " + this.tempSize + "size " + HashMap.this.size);
	            if (this.tempSize < MyHashMap.this.size) {
	                return true;
	            }
	            return false;
	        }

	        @Override
	        public HashMapNode next() {
	            HashMapNode hashMapNode = null;
	            // System.out.println(this.currentListSize + " " + this.bucketIndex + " " + this.currentListIndex + " " + this.tempSize + " " + HashMap.this.buckets.length);
	            if (this.currentListSize > 0) {
	                if (this.bucketIndex < MyHashMap.this.buckets.length) {
	                    if (this.currentListIndex < this.currentListSize) {
	                        hashMapNode = MyHashMap.this.buckets[this.bucketIndex].get(this.currentListIndex);
	                        this.currentListIndex++;
	                        this.tempSize++;
	                        if (this.currentListIndex == this.currentListSize) {
	                            this.currentListIndex = 0;
	                            this.bucketIndex++;
	                            if (this.tempSize < MyHashMap.this.size) {
	                                this.currentListSize = MyHashMap.this.buckets[this.bucketIndex].size();
	                            }
	                        }
	                    }
	                }
	            } else {
	                while (this.bucketIndex < MyHashMap.this.buckets.length && this.currentListSize == 0) {
	                    this.bucketIndex++;
	                    this.currentListSize = MyHashMap.this.buckets[this.bucketIndex].size();
	                }
	                this.currentListIndex = 0;
	                hashMapNode = MyHashMap.this.buckets[this.bucketIndex].get(this.currentListIndex++);
	                this.currentListSize = MyHashMap.this.buckets[this.bucketIndex].size();
	                this.tempSize++;
	                if (this.currentListIndex == this.currentListSize) {
	                    this.currentListIndex = 0;
	                    this.bucketIndex++;
	                    if (this.tempSize < MyHashMap.this.size) {
	                        this.currentListSize = MyHashMap.this.buckets[this.bucketIndex].size();
	                    }
	                }
	            }
	            return hashMapNode;
	        }

	        @Override
	        public void remove() {
	            throw new UnsupportedOperationException();
	        }
	    };
	    return it;
	}

}
