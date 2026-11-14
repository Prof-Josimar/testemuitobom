package util;

/**
 * Funções de apoio para CPF: limpar, validar e formatar.
 * Os métodos são static, então não precisamos criar um objeto:
 * CpfUtil.valido("123.456.789-09")
 */
public class CpfUtil {

    // Remove tudo que não é número: "123.456.789-09" -> "12345678909"
    public static String limpar(String cpf) {
        if (cpf == null) {
            return "";
        }
        return cpf.replaceAll("\\D", "");
    }

    // Valida o CPF pelos dois dígitos verificadores
    public static boolean valido(String cpfEntrada) {
        String cpf = limpar(cpfEntrada);

        // precisa ter 11 dígitos e não pode ser tudo igual (111.111.111-11)
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma1 = 0;
        int soma2 = 0;
        for (int i = 0; i < 9; i++) {
            int num = cpf.charAt(i) - '0';
            soma1 += num * (10 - i);
            soma2 += num * (11 - i);
        }

        int digito1 = (soma1 % 11 < 2) ? 0 : 11 - (soma1 % 11);
        soma2 += digito1 * 2;
        int digito2 = (soma2 % 11 < 2) ? 0 : 11 - (soma2 % 11);

        return digito1 == cpf.charAt(9) - '0'
                && digito2 == cpf.charAt(10) - '0';
    }

    // "12345678909" -> "123.456.789-09"
    public static String formatar(String cpf) {
        String c = limpar(cpf);
        if (c.length() != 11) {
            return cpf;
        }
        return c.substring(0, 3) + "." + c.substring(3, 6) + "."
                + c.substring(6, 9) + "-" + c.substring(9);
    }
}
