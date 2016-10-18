package br.com.adfgvxt;

public class Main {

	public static void main(String[] args) {
		String tradutor = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@. ";
		CypherIF cypher = new Cypher(tradutor);
		String criptografada = cypher.encrypt("EH NOIS QUE TA");
		String descriptografada = cypher.decrypt("FXFGAVAVDXAADTAFFAFGFDFAFGAAFXDDFADTXDATDXAADDDVXFAFFADX");
		
		System.out.println(criptografada+"\n"+descriptografada.toLowerCase());
	}
}
