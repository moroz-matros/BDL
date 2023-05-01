package l7.var1;

/*
 * 3. В тексте после буквы Р, если она не последняя в слове,
 * ошибочно напечатана буква А вместо О. Внести исправления в текст.
 *
 * 4. В тексте слова заданной длины заменить указанной подстрокой,
 * длина которой может не совпадать с длиной слова.
 */

public class Main {
    public static void main(String[] args) {
        String text = "some randome PO text with PA APA LAPA PATA word P";
        String updatedStr = text.replaceAll("(PA\\b)", "PO");
        System.out.println(updatedStr);

        int length = 4;
        updatedStr = text.replaceAll("\\b\\w{" + length + "}\\b", "substring");
        System.out.println(updatedStr);
    }
}
