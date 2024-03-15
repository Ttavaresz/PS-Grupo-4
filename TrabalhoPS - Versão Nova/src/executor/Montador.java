package executor;


import java.math.BigInteger;

public class Montador {
    String binario;
    String mnemonico;
    String codigoFonte;
    Registrador PC = new Registrador("000000");
    

      //Converte o codigo fonte(HexaDecimal) para código de maquina(binario)
    
    public void converteBinario() {
        this.binario = new BigInteger(this.codigoFonte, 16).toString(2);
        System.out.println(this.binario);
    }
    
    
    //Converte os dois primeiros caracteres da String para o opcode e baseado nesse upcode é retornado a mnemonica 

    public void criaMnemonica() {
    	String opcode = this.codigoFonte.substring(0 , 2);
        switch (opcode) {
        
        	case "14":
        	this.mnemonico = "STL";
        	break;
        	
            case "18":
                this.mnemonico = "ADD";
                break;

            case "90":
                this.mnemonico = "ADDR";
                break;

            case "40":
                this.mnemonico = "AND";
                break;

            case "B4":
                this.mnemonico = "CLEAR";
                break;

            case "28":
                this.mnemonico = "COMP";
                break;

            case "A0":
                this.mnemonico = "COMPR";
                break;

            case "24":
                this.mnemonico = "DIV";
                break;

            case "9C":
                this.mnemonico = "DIVR";
                break;

            case "3C":
                this.mnemonico = "J";
                break;

            case "30":
                this.mnemonico = "JEQ";
                break;

            case "38":
                this.mnemonico = "JLT";
                break;

            case "48":
                this.mnemonico = "JSUB";
                break;

            case "00":
                this.mnemonico = "LDA";
                break;

            case "68":
                this.mnemonico = "LDB";
                break;

            case "50":
                this.mnemonico = "LDCH";
                break;

            case "6C":
                this.mnemonico = "LDS";
                break;

            case "74":
                this.mnemonico = "LDT";
                break;

            case "20":
                this.mnemonico = "MUL";
                break;

            case "98":
                this.mnemonico = "MULR";
                break;

            case "44":
                this.mnemonico = "OR";
                break;

            case "D8":
                this.mnemonico = "RD";
                break;

            case "4C":
                this.mnemonico = "RSUB";
                break;

            case "A4":
                this.mnemonico = "SHIFTL";
                break;

            case "A8":
                this.mnemonico = "SHIFTR";
                break;

            case "0C":
                this.mnemonico = "STA";
                break;

            case "78":
                this.mnemonico = "STB";
                break;

            case "54":
                this.mnemonico = "STCH";
                break;

            case "1C":
                this.mnemonico = "SUB";
                break;

            case "94":
                this.mnemonico = "SUBR";
                break;

            case "E0":
                this.mnemonico = "TD";
                break;

            case "2C":
                this.mnemonico = "TIX";
                break;

            case "B8":
                this.mnemonico = "TIXR";
                break;

            case "DC":
                this.mnemonico = "WD";
                break;

            default:
                this.mnemonico = "";
                break;
        }
        System.out.println(this.mnemonico);
    }

    public void atualizarCodigoFonte(String codigoFonte) {
        this.codigoFonte = codigoFonte;
        System.out.println("Código-fonte atualizado: " + this.codigoFonte);
    }

}
