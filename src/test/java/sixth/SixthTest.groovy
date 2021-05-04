package sixth

import spock.lang.Specification

class SixthTest extends Specification {

    private static final String RESOURCES_PATH = 'src/test/resources/root'
    private static final String FIRST_FOLDER = "${RESOURCES_PATH}/first"
    private static final String SECOND_FOLDER = "${RESOURCES_PATH}/second"
    private static final String THIRD_FOLDER = "${RESOURCES_PATH}/third"

    private static final String FOURTH_FOLDER = "${RESOURCES_PATH}/first/first_in_first"
    private static final String FIFTH_FOLDER = "${RESOURCES_PATH}/first/second_in_first"
    private static final String SIXTH_FOLDER = "${RESOURCES_PATH}/first/third_in_first"

    private static final String SEVENTH_FOLDER = "${RESOURCES_PATH}/second/first_in_second"
    private static final String EIGHT_FOLDER = "${RESOURCES_PATH}/second/second_in_second"

    private static final String TENTH_FOLDER = "${RESOURCES_PATH}/second/first_in_third"

    private static final String FIRST_FILE_NAME = '/first_file.txt'
    private static final String SECOND_FILE_NAME = '/second_file.txt'

    private File rootFolder = new File(RESOURCES_PATH)
    private File secondFolder = new File(FIRST_FOLDER)
    private File thirdFolder = new File(SECOND_FOLDER)
    private File fourthFolder = new File(THIRD_FOLDER)

    private File fiveFolder = new File(FOURTH_FOLDER)
    private File sixthFolder = new File(FIFTH_FOLDER)
    private File seventhFolder = new File(SIXTH_FOLDER)

    private File eightFolder = new File(SEVENTH_FOLDER)
    private File ninthFolder = new File(EIGHT_FOLDER)

    private File tenthFolder = new File(TENTH_FOLDER)

    private File firstFile = new File(FIRST_FOLDER + FIRST_FILE_NAME)
    private File secondFile = new File(SECOND_FOLDER + FIRST_FILE_NAME)
    private File thirdFile = new File(THIRD_FOLDER + FIRST_FILE_NAME)
    private File fourthFile = new File(FOURTH_FOLDER + FIRST_FILE_NAME)
    private File fifthFile = new File(FIFTH_FOLDER + FIRST_FILE_NAME)
    private File sixthFile = new File(SIXTH_FOLDER + FIRST_FILE_NAME)
    private File seventhFile = new File(SEVENTH_FOLDER + FIRST_FILE_NAME)
    private File eightFile = new File(EIGHT_FOLDER + SECOND_FILE_NAME)
    private File ninthFile = new File(TENTH_FOLDER + SECOND_FILE_NAME)

    def setup() {
        rootFolder.mkdir()
        secondFolder.mkdir()
        thirdFolder.mkdir()
        fourthFolder.mkdir()
        fiveFolder.mkdir()
        sixthFolder.mkdir()
        seventhFolder.mkdir()
        eightFolder.mkdir()
        ninthFolder.mkdir()
        tenthFolder.mkdir()

        firstFile.createNewFile()
        secondFile.createNewFile()
        thirdFile.createNewFile()
        fourthFile.createNewFile()
        fifthFile.createNewFile()
        sixthFile.createNewFile()
        seventhFile.createNewFile()
        eightFile.createNewFile()
        ninthFile.createNewFile()
    }

    def cleanup() {
        rootFolder.deleteDir()
    }

    def "existAllFiles"() {
        expect:
        firstFile.exists()
        secondFile.exists()
        thirdFile.exists()
        fourthFile.exists()
        fifthFile.exists()
        sixthFile.exists()
        seventhFile.exists()
        eightFile.exists()
        ninthFile.exists()

        rootFolder.exists()
        secondFolder.exists()
        thirdFolder.exists()
        fourthFolder.exists()
        fiveFolder.exists()
        sixthFolder.exists()
        seventhFolder.exists()
        eightFolder.exists()
        ninthFolder.exists()
        tenthFolder.exists()
    }

    def "DeleteFiles"() {

        Sixth.deleteFiles(RESOURCES_PATH)

        expect:
        !firstFile.exists()
        !secondFile.exists()
        !thirdFile.exists()
        !fourthFile.exists()
        !fifthFile.exists()
        !sixthFile.exists()
        !seventhFile.exists()
        !eightFile.exists()
        !ninthFile.exists()

        rootFolder.exists()
        secondFolder.exists()
        thirdFolder.exists()
        fourthFolder.exists()
        fiveFolder.exists()
        sixthFolder.exists()
        seventhFolder.exists()
        eightFolder.exists()
        ninthFolder.exists()
        tenthFolder.exists()
    }
}
