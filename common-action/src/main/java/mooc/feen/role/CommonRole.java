package mooc.feen.role;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public  class CommonRole {
    /**
     * 攻击力
     */
    private Integer attack;

    /**
     * 生命值
     */
    private Integer health;

    /**
     * 防御力
     */
    private Integer defensive;

    /**
     * 能量值
     */
    private Integer energy;

    /**
     * 速度
     */
    private Integer speed;
}
