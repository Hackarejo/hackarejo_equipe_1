package sutil.ws;

import org.apache.commons.codec.digest.DigestUtils;

public class ConverteSenhaWS {

	public String converte(String senha) {

		String senhaMD5 = DigestUtils.md5Hex(senha);

		return senhaMD5;
	}
}