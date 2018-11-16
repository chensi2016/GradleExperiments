public class DecodeStringRewrite {
    private int i = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println("i= "+ i + " sb=" + sb.toString());

            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                i++;
                System.out.println("Entering decodeString with i = "+ i);
                String str = decodeString(s);
                for (int k = 0; k < num; k++)
                    sb.append(str);
                num = 0;
            } else if (c == ']') {
                System.out.println("End of decodeString with i = "+ i + " sb=" + sb.toString());
                return sb.toString();
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}


