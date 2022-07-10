import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        System.out.println("After Clearing Array:");
        Arrays.fill(storage, 0, count, null);
    }

    void save(Resume r) {
        for (int i = 0; i <= count; i++) {
            if (storage[i] == null) {
                storage[i] = r;
            }
        }
        count++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int count = 0;
        int remainingElements = storage.length - (count + 1);
        System.arraycopy(storage, count + 1, storage, count, remainingElements);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] newArr = Arrays.copyOf(storage, count);
        return newArr;
    }

    int size() {
        return count;
    }
}
