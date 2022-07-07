import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int k = 0;

    void clear() {
        storage = null;
    }

    void save(Resume r) {

        for (int i = 0; i <= k; i++) {
            if (storage[i] == null) {
                storage[i] = r;
            }
        }
        k++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].toString())) {
                count = i;
                break;
            }
        }
        Resume[] arrNewStorage = new Resume[storage.length - 1];
        int remainingElements = storage.length - (count + 1);
        System.arraycopy(storage, 0, arrNewStorage, 0, count);
        System.arraycopy(storage, count + 1, arrNewStorage, count, remainingElements);
        //System.out.println("Elements -- "  + Arrays.toString(arrNewStorage));
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] newArr = new Resume[k];

        for (int i = 0; i < k; i++) {
            if (storage != null) {
                newArr[i] = storage[i];
            }
        }
        return newArr;
    }


    int size() {
        return storage.length;
    }
}
