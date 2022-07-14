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
        storage[count] = r;
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
        int i = 0;
        try {
            for (; i < count; i++) {
                if (uuid.equals(storage[i].toString())) {
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.err.println("there is no such resume");
        }

        int remainingElements = storage.length - (i + 1);
        System.arraycopy(storage, i + 1, storage, i, remainingElements);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    int size() {
        return count;
    }
}
