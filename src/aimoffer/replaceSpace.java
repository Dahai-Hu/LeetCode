package aimoffer;

/**
 * @hurusea
 * @create2020-03-20 9:49
 */
public class replaceSpace {
    public static void main(String[] args) {
        replaceSpace replaceSpace = new replaceSpace();
        String s = replaceSpace.replaceSpace("We are happy.");
        System.out.println(s);
    }

    public String replaceSpace(String s) {
//        String[] s1 = s.split(" ");
//        for (int i = 0; i <s1.length ; i++) {
//            if (s1[i]==" "){
//                s1[i]="%20";
//            }
//        }
//        StringBuffer result = new StringBuffer();
//        for (String string:s1) {
//            result.append(string);
//        }
//        return result.toString();
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}
