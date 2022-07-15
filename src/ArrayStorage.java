import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;
    Resume[] newStorage = null;

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
        try {
            for (int i = 0; i < count; i++) {
                if (uuid.equals(storage[i].toString())) {
                    newStorage = new Resume[storage.length - 1];
                    for (int index = 0; index < i; index++) {
                        newStorage[index] = storage[index];
                    }
                    for (int j = i; j < storage.length - 1; j++) {
                        newStorage[j] = storage[j + 1];
                    }
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.err.println("there is no such resume");
        }
        storage = newStorage.clone();
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
