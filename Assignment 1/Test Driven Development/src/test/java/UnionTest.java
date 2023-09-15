import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class UnionTest {

    @Test
    public void testUnionOfArrays_A2ElementsGreaterA1() {

        //Arrange phase of the Test case
        Main arrayUnionobj = new Main();
        //Act phase of the Test case
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {4, 5, 6, 7};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7};
        Integer[] result = arrayUnionobj.ArrayUnion(array1, array2);
        //Assert phase of the Test case
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnionOfArrays_A1ElementsGreaterA2() {

        //Arrange phase of the Test case
        Main arrayUnionobj = new Main();
        //Act phase of the Test case
        Integer[] array1 = {1, 2, 3, 8};
        Integer[] array2 = {4, 5, 6};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 8};
        Integer[] result = arrayUnionobj.ArrayUnion(array1, array2);
        //Assert phase of the Test case
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnionOfArrays_RandomValues() {

        //Arrange phase of the Test case
        Main arrayUnionobj = new Main();
        //Act phase of the Test case
        Integer[] array1 = {1, 2, 3, 8, 10, 13};
        Integer[] array2 = {4, 5, 6, 12, 7};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 8, 10, 12, 7, 13};
        Integer[] result = arrayUnionobj.ArrayUnion(array1, array2);
        //Assert phase of the Test case
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnionOfArrays_EmptyArray() {

        //Arrange phase of the Test case
        Main arrayUnionobj = new Main();
        //Act phase of the Test case
        Integer[] array1 = {};
        Integer[] array2 = {4, 5, 6, 12, 7};
        Integer[] expected = {4, 5, 6, 12, 7};
        Integer[] result = arrayUnionobj.ArrayUnion(array1, array2);
        //Assert phase of the Test case
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnionOfArrays_SameElements() {

        //Arrange phase of the Test case
        Main arrayUnionobj = new Main();
        //Act phase of the Test case
        Integer[] array1 = {4, 5, 6};
        Integer[] array2 = {4, 5, 6};
        Integer[] expected = {4, 5, 6};
        Integer[] result = arrayUnionobj.ArrayUnion(array1, array2);
        //Assert phase of the Test case
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnionOfArrays_A1ElementsSmallarA2() {

        //Arrange phase of the Test case
        Main arrayUnionobj = new Main();
        //Act phase of the Test case
        Integer[] array1 = {4, 5, 6};
        Integer[] array2 = {1, 2, 3};
        Integer[] expected = {1, 2, 3, 4, 5, 6};
        Integer[] result = arrayUnionobj.ArrayUnion(array1, array2);
        //Assert phase of the Test case
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnionOfArrays_NegativeElements() {

        //Arrange phase of the Test case
        Main arrayUnionobj = new Main();
        //Act phase of the Test case
        Integer[] array1 = {-4, -5, -6};
        Integer[] array2 = {-1, -2, -3};
        Integer[] expected = {-4, -5, -6, -1, -2, -3};
        Integer[] result = arrayUnionobj.ArrayUnion(array1, array2);
        //Assert phase of the Test case
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnionOfArrays_NegativePositiveElements() {

        //Arrange phase of the Test case
        Main arrayUnionobj = new Main();
        //Act phase of the Test case
        Integer[] array1 = {-4, -5, 6};
        Integer[] array2 = {-1, 2, -3};
        Integer[] expected = {-4, -5, -1, 2, -3, 6};
        Integer[] result = arrayUnionobj.ArrayUnion(array1, array2);
        //Assert phase of the Test case
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnionWithNullArray() {
        //Arrange phase of the Test case
        Main arrayUnionobj = new Main();
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = null;
        Integer[] result = arrayUnionobj.ArrayUnion(array1, array2);
        assertNull(result);
    }

}