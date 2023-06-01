package mooc.feen.action;

import mooc.feen.role.CommonRole;

import java.util.List;

public class BasicAction {

    /**
     * 普通攻击
     * @param role      发动着
     * @param target    目标
     */
    public static void atk(CommonRole role, List<CommonRole> target) {
        for (CommonRole commonRole : target) {
//            commonRole.
        }
    }

    /**
     * 战技
     * @param role      发动者
     */
    public static void skill(CommonRole role) {

    }

    /**
     * 大招
     * @param role      发动者
     * @param target    目标
     */
    public static void ultimate(CommonRole role, List<CommonRole> target) {

    }

    /**
     * 天赋
     * @param role      发动者
     */
    public static void talent(CommonRole role) {

    }
    /**
     * 秘技
     * @param role      发动者
     */
    public static void technique(CommonRole role) {

    }

}
