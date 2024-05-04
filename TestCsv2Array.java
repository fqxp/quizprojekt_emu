import java.util.Arrays;

class TestCsv2Array {
  public void testSort2DArrayBasedOnColumnNumber() {
    String array[][] = {
      { "1", "2", "3" },
      { "2", "3", "2" },
      { "3", "1", "1" },
    };

    Csv2Array.Sort2DArrayBasedOnColumnNumber(array, 2);

    print2DArray(array);
    assert(Arrays.deepEquals(array, new String[][] {
      { "3", "1", "1" },
      { "1", "2", "3" },
      { "2", "3", "2" },
    }));
  }

  public static void print2DArray(String array[][]) {
    for(int i = 0; i < array.length; i++) {
      for(int j = 0; j < array[i].length; j++){
        String value = array[i][j];
        System.out.print(value + "\t");
      }
      System.out.println();
    }
  }

  public static void main(String argv[]) {
    TestCsv2Array test = new TestCsv2Array();

    test.testSort2DArrayBasedOnColumnNumber();
  }
}
