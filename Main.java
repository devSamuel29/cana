import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[] A = { 86, 78, 36, 61, 67, 34, 58, 42, 35, 59, 62, 28, 60, 37, 12 };
		System.out.println("Vetor A:");
		// maxHeapFy(A, 0); // descomente apenas para a execucao do passo 5
		// maxHeapFy(A, 2); //descomente apenas para a execucao do passo 6;
		// maxHeapFy(A, 5); //descomente apenas para a execucao do passo 6
		// maxHeapFy(A, 5); // descomente apenas para a execucao do passo 7
		// maxHeapFy(A, 2); // descomente apenas para a execucao do passo 7
		imprimeVetor(A);
		System.out.println("Heap A:");
		imprimeHeap(A);
		// System.out.println("------------------------------------------------------------------------------------------");
		// int[] B = criaVetorAleatorio(15);
		// System.out.println("Vetor B:");
		// buildMaxHeap(B);
		// imprimeVetor(B);
		// System.out.println("Heap B:");
		// imprimeHeap(B);
	}

	public static void maxHeapFy(int[] array, int index) {
		int leftChildIndex = getLeftChild(index);
		int rightChildIndex = getRightChild(index);

		int lagerst;

		if (leftChildIndex < array.length && array[leftChildIndex] > array[index]) {
			lagerst = leftChildIndex;
		} else {
			lagerst = index;
		}

		if (rightChildIndex < array.length && array[rightChildIndex] > array[lagerst]) {
			lagerst = rightChildIndex;
		}

		if (lagerst != index) {
			int aux;

			aux = array[lagerst];
			array[lagerst] = array[index];
			array[index] = aux;

			maxHeapFy(array, lagerst);
		}
	}

	public static void buildMaxHeap(int[] array) {
		int n = array.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapFy(array, i);
		}
	}

	public static int getLeftChild(int index) {
		return index * 2 + 1;
	}

	public static int getRightChild(int index) {
		return index * 2 + 2;
	}

	static int[] criaVetorAleatorio(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(10 * n);
		}
		return A;
	}

	static void imprimeVetor(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.printf("%6d", A[i]);
		}
		System.out.print("\n\n\n");
	}

	static void imprimeHeap(int[] A) {
		int h = (int) (Math.log(A.length) / Math.log(2));
		int espacos = calculaEspacos(h);
		for (int i = 0; i <= h; i++) {
			for (int j = 1; j <= Math.pow(2, i); j++) {
				if ((int) (Math.pow(2, i)) - 1 + (j - 1) >= A.length)
					break;
				imprimeEspacos(espacos);
				System.out.printf("%3d", A[(int) (Math.pow(2, i)) - 1 + (j - 1)]);
				imprimeEspacos(espacos);
				if (j < Math.pow(2, i)) {
					System.out.printf("%3s", "");
				}
			}
			espacos = (espacos - 3) / 2;
			System.out.println();
		}
	}

	static int calculaEspacos(int h) {
		int espacos = 3;
		for (int i = 1; i <= h; i++) {
			espacos = 2 * espacos + 3;
		}
		return espacos;
	}

	static void imprimeEspacos(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(" ");
		}
	}
}
