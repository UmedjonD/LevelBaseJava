import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int countSizeArr = 0;

    void clear() {
        System.out.println("After Clearing Array:");
        Arrays.fill(storage, null);
    }

    void save(Resume r) {

        for (int i = 0; i <= countSizeArr; i++) {
            if (storage[i] == null) {
                storage[i] = r;
            }
        }
        countSizeArr++;
    }

    String get(String uuid) {
        for (Resume resume : storage) {
            if (uuid.equals(resume.toString())) {
                return resume.toString();
            } else {
                return "такого значения нет";
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] arrNewStorage = new Resume[storage.length - 1];
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i].toString())) {
                count = i;
                break;
            }
        }
        int remainingElements = storage.length - (count + 1);
        //System.arraycopy(storage, 0, arrNewStorage, 0, count);
        System.arraycopy(storage, count + 1, storage, count, remainingElements);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] newArr = new Resume[countSizeArr];
        for (int i = 0; i < countSizeArr; i++) {
            if (storage != null) {
                newArr[i] = storage[i];
            }
        }
        return newArr;
    }

    int size() {
        return countSizeArr;
    }
}
