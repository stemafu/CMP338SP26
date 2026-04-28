import java.util.Iterator;

public class HashTable <E extends KeyedElementInterface<K>, K>
implements HashTableInterface<E, K>{
	
	private static int NUMBER_OF_BUCKETS = 17;
	private  Bucket [] buckets;
	private int numElements;
	
	public HashTable() {
		buckets = new Bucket[NUMBER_OF_BUCKETS];
		this.numElements = 0;
		
		for(int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket(null, true);
			//buckets[i].setEmptyFromTheBegining(true); 
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.numElements;
	}

	@Override
	public boolean isEmpty() {
		return (this.numElements == 0);
	}

	@Override
	public HashTableInterface<E, K> copy() throws InstantiationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E insert(E element) {
		
		
		K key = element.getKey();
		
		int hashCode = this.hash(key.hashCode());
		
		// System.out.println(hashCode);
		
		
		int probeNum = 1;
		/*
		 * The loops is used to search for an empty bucket where
		 * we want to insert
		 */
		while (buckets[hashCode].getElement() != null) {
			
			
			
			E elementAtBucket = (E)buckets[hashCode].getElement();
		
			if (elementAtBucket.getKey().equals(key)  ) {
				buckets[hashCode].setElement(element);
				return elementAtBucket;
			}
			
		
			hashCode = probe(hashCode, probeNum);
		}
		
		
		numElements++;
		buckets[hashCode] = new Bucket(element, false);
		
		
		return null;
	}

	private int hash(int key) {
		int hashCode = key % buckets.length;
		return hashCode;
	}
	
	private int probe(int hashCode, int i) {
		//return (hashCode + 1) % buckets.length; // linear probing
		
		return (hashCode + i + (i * i)) % buckets.length;
	}
	
	@Override
	public E get(K key) {
		
		
		int hashCode = this.hash(key.hashCode());
		
		
		//E elementAtBucket = (E)buckets[hashCode].getElement();
		int probeNum = 1;
		
		while( !(((E)buckets[hashCode].getElement()).getKey().equals(key))) {
			hashCode = probe(hashCode, probeNum);
		}
		
		return (E)buckets[hashCode].getElement();
	}

	@Override
	public E remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSizeOfLargestBucket() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAverageBucketSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] getBuckets() {
		// TODO Auto-generated method stub
		return null;
	}

}
