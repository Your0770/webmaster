package chap13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapMain {
	public static void main(String[] args) {
		
		// map : 키와 값으로 구성된 entry 저장
		Map<String, Integer> map = new HashMap<>();
		
		// 객체 저장
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		
		// map 크기
		System.out.println("총 Entry 수 : " + map.size());
		
		// 객체 찾기
		System.out.println("홍길동 : " + map.get("홍길동"));
		System.out.println();
		
		// 객체 하나씩 처리
		System.out.println("전체 읽어오기------------");
		Set<String> keySet = map.keySet();
		Iterator<String> keyIr = keySet.iterator();
		while(keyIr.hasNext()) {
			String key = keyIr.next();
			Integer value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		//향상된 for
		for(String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println();
		
		//객체 삭제
		map.remove("홍길동");
		System.out.println("총 Entry 수 : " + map.size());
		
		// 객체 하나씩 처리
		System.out.println("전체 읽어오기------------");
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIr = entrySet.iterator();
		while(entryIr.hasNext()) {
			Map.Entry<String, Integer> entry = entryIr.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		//향상된 for
		for(Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println();
		
		//객체 전체 삭제
		map.clear();
		System.out.println("총 Entry 수 : " + map.size());
		
		
	}
	
}

