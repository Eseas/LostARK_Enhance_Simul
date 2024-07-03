// 장인의 기운은 강화 시도 확률의 46.5%만큼 쌓인다.

public class Equipment {
    private double janggibeak = 0.0;
    private int bonus_try_count = 0;

    public double getJanggibeak() {
        return janggibeak;
    }

    public int getBonus_try_count() {
        return bonus_try_count;
    }

    public boolean argos_try_enhance(
            int enhanced_level,
            double percent)
    {
        if(janggibeak >= 100.0) {
            System.out.println("장기백입니다.");
            return true;
        }
        if(enhanced_level <= 5) {
            return true;
        }

        if(percent >= 10000) {
            return true;
        }

        int result = (int) (Math.random() * 10000);

        if(result <= percent) {
            return true;
        } else {
            if(bonus_try_count < 10) {
                bonus_try_count++;
            }
            janggibeak = Math.min(100.0, janggibeak + ((percent / 100) * 0.465));
            return false;
        }
    }
}