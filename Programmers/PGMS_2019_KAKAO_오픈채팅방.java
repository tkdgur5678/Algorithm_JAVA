import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
		for (String string : record) {
			StringTokenizer st = new StringTokenizer(string);
			String command = st.nextToken();
			if(!command.equals("Leave")) {
				hm.put(st.nextToken(), st.nextToken());
			}
		}
		List<String> list = new ArrayList<>();
		int count = 0;
		for (String string : record) {
			StringTokenizer st = new StringTokenizer(string);
			String command = st.nextToken();
			if(command.equals("Enter")) {
				list.add(hm.get(st.nextToken())+"님이 들어왔습니다.");
			} else if(command.equals("Leave")) {
				list.add(hm.get(st.nextToken())+"님이 나갔습니다.");
			}
		}
		String[] result = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
        return result;
    }
}
