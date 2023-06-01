package mooc.feen.qingque;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mooc.feen.role.CommonRole;

import java.security.SecureRandom;
import java.util.*;

/**
 * 青雀本体，不计算遗物，以满级80级、0命的面板为基础。
 */
@Builder
@NoArgsConstructor
@Data
public class QingQue extends CommonRole {

    /**
     * 目的：传入一个牌列表，在程序中获取0，1，2随机数到列表中，每次获取两个，按照个数多的放前面，个数少的放后面，相同的从小到大排列，
     * 最终列表中四张牌点数一致时返回原数组，不做处理
     * @param pais
     * @return
     */
    public List<Integer> skill(List<Integer> pais) {
        if (pais.size() >= 4 && isTogether(pais)){
            System.out.println("4张牌已一致");
            System.out.println();
            return pais;
        }

        //用于存储牌的个数
        Map<Integer,Integer> map = new HashMap<>();

        // 顺序存储队列
        Queue<Integer> queue = new LinkedList<>();

        // 预处理，当pais中有牌的时候添加进map和queue中
        if (pais.size() != 0) {
            preHandler(pais,map,queue);
        }
//        int seed = Integer.parseInt(String.format("%ts", new Date()));
//        Random random = new Random(seed);
        SecureRandom random = new SecureRandom();
        Integer first = random.nextInt(3);
        Integer twice = random.nextInt(3);
        System.out.println("抽出牌："+first+":"+twice);


        put(map,first);
        put(map,twice);
        queue.offer(first);
        queue.offer(twice);


        // 对queue做判断，数最多的放前面
        List<Integer> tmp = new ArrayList<>();
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            tmp.add(iterator.next());
        }
        System.out.println("排序前tmp:"+tmp);

        tmp.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) < map.get(o2)){
                    return 1;
                } else if(map.get(o1)==map.get(o2)) {
                    return o1-o2;
                }
                else {
                    return -1;
                }
            }
        });
        System.out.println("排序后tmp:"+tmp);

        pais = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            if (i >= tmp.size()) {
                pais.add(null);
            } else {
                pais.add(tmp.get(i));
            }
        }

        return pais;
    }

    public boolean isTogether(List<Integer> pais) {
        Integer k = pais.get(0);
        for (int i = 1; i < (pais.size() > 4 ? 4 : pais.size()); i++) {
            if (pais.get(i) != k){
                return false;
            }
        }
        return true;
    }

    public void preHandler(List<Integer> pais,Map<Integer,Integer> map,Queue<Integer> queue) {
        for (int i = 0; i < pais.size(); i++) {
            if (pais.get(i) == null) {
                break;
            }
            put(map,pais.get(i));
            queue.offer(pais.get(i));
        }
    }

    public void put(Map<Integer,Integer> map,Integer target) {
        if (map.containsKey(target)) {
            map.put(target,map.get(target)+1);
        } else {
            map.put(target,1);
        }
    }
}
