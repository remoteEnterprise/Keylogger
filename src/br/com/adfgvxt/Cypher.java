package br.com.adfgvxt;

public class Cypher implements CypherIF {
	private char[][] translate;
	
	public Cypher(String alphabet) {
		this.translate = new char[7][7];	//ADFGVX VERTICAL AND 
											//ADFGVX HORIZONTAL
		int c = 0;
		for(int x = 0; x < 7; x++) {
			for(int y = 0; y < 7; y++) {
				if(c != alphabet.length()) { 
					this.translate[x][y] = alphabet.charAt(c++);
				}
			}
		}
	}
	@Override
	public String encrypt(String message) {
		String messageEncrypted = "";
		String adfgvx = "ADFGVXT";
		message.toUpperCase();
		for(int z = 0; z < message.length(); z++) {
			char c = message.charAt(z);
			for(int x = 0; x < 7; x++) {
				for(int y = 0; y < 7; y++) {
					if(this.translate[x][y] == c) {
						messageEncrypted += adfgvx.charAt(x);
						messageEncrypted += adfgvx.charAt(y);
						//QUANTO MAIS EU ADD COISA A STRING
						//MAIS TEREI QUE AUMENTAR O +=3 NO DECRYPT
						//AUMENTANDO O TAMANHO DA MATRIZ
						//AUMENTA-SE TAMBEM O TAMANHO DA STRING PADRAO ADFGVX
					}
				}
			}
		}
		
		return messageEncrypted;
	}

	@Override
	public String decrypt(String message) {
		String messageDecrypted = "";
		String adfgvx = "ADFGVXT";
		for(int z = 0; z < message.length(); z+=2) {	
			char a = message.charAt(z);
			char b = message.charAt(z+1);
			messageDecrypted += this.translate[adfgvx.indexOf(a)][adfgvx.indexOf(b)];
		}
		return messageDecrypted;
	}

}
