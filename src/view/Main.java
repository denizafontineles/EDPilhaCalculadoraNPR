package view;
import javax.swing.JOptionPane;
import controller.CalculadoraController;
import com.deniza.utils.pilha.integer.Pilha;

public class Main {
	
	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		CalculadoraController controller = new CalculadoraController();

		int opcao = 0;
		int resultado = 0;

		String[] actionButtons = { "Adicionar número", "Executar operação", "Cancelar" };
		String[] opButtons = { "+", "*", "-", "/", "Cancelar" };

		do {
			opcao = JOptionPane.showOptionDialog(null, "Qual será a ação?", "Confirmation",
					JOptionPane.INFORMATION_MESSAGE, 0, null, actionButtons, actionButtons[0]);

			if (opcao == 0) {
				int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira um valor"));
				controller.insereValor(pilha, valor);
			}

		} while (opcao != 1 && opcao != 2);

		if (opcao == 1) {
			 do {
				int op = JOptionPane.showOptionDialog(null, "Qual será a operação? \n " + resultado, "Confirmation",
						JOptionPane.INFORMATION_MESSAGE, 0, null, opButtons, opButtons[2]);
				
				if (op == 4) {
					break;
				}
				
				try {
					resultado = controller.rpn(pilha, op);
					controller.insereValor(pilha, resultado);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, resultado);
					e.printStackTrace();
					break;
				}

			} while (!pilha.isEmpty());
			 
			 
		}

	}
	

}
