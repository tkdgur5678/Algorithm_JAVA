import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2002_Ãß¿ù {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			m.put(str, i);
		}
		
		String[] arr = new String[N];
		int count = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(m.get(arr[i]) > m.get(arr[j])) {
					count += 1;
					break;
				}
			}
		}
		System.out.println(count);
	}

}
