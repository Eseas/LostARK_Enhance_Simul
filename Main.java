import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Equipment equip = new Equipment();
        Scanner scanner = new Scanner(System.in);
        int kind = -1;
        int level = -1;
        double percent;
        int sub_count;
        boolean flag = true;
        int enhance_count = 0;

        System.out.print("어떤 장비입니까? : ");
        kind = scanner.nextInt();
        System.out.print("몇 강화입니까? : ");
        level = scanner.nextInt();

        while(flag) {
            double subPercent = 0.0;
            switch(kind) {
                case 1:
                    percent = ( Argos.BASIC_ENHANCE_PERCENT[level] +
                            ((double) Argos.PLUS_ENHANCE_PERCENT[level] * equip.getBonus_try_count()));

                    System.out.println("기본 강화 확률 : " + (percent / 100) + "%");
                    System.out.println("태양의 축복은 몇 개? : ");
                    System.out.println("최대 " +
                            Math.min(
                                    Argos.FIRST_SUB_MAX_COUNT[level],
                                    (int) (((double) (Argos.BASIC_ENHANCE_PERCENT[level] - subPercent) / Argos.FIRST_SUB_PERCENT[level]) + 0.99)
                            ) + "개 넣을 수 있어.");
                    sub_count = scanner.nextInt();

                    if(sub_count > Argos.FIRST_SUB_MAX_COUNT[level]) {
                        System.out.println("너무 많이 넣었어. 최대값으로 넣을게.");
                        sub_count = Argos.FIRST_SUB_MAX_COUNT[level];
                    }

                    subPercent = subPercent + (Argos.FIRST_SUB_PERCENT[level] * sub_count);
                    if(subPercent > Argos.BASIC_ENHANCE_PERCENT[level]) {
                        subPercent = Argos.BASIC_ENHANCE_PERCENT[level];
                    }
                    System.out.println("태양의 축복을 " + sub_count + "개 넣은 강화 확률 : " + ((percent + subPercent) / 100) + "%");

                    System.out.println("태양의 은총은 몇 개? : ");
                    System.out.println("최대 " +
                            Math.min(
                                    Argos.SECOND_SUB_MAX_COUNT[level],
                                    (int) (((double) (Argos.BASIC_ENHANCE_PERCENT[level] - subPercent) / Argos.SECOND_SUB_PERCENT[level]) + 0.99)
                            ) + "개 넣을 수 있어.");
                    sub_count = scanner.nextInt();

                    if(sub_count > Argos.SECOND_SUB_MAX_COUNT[level]) {
                        System.out.println("너무 많이 넣었어. 최대값으로 넣을게.");
                        sub_count = Argos.SECOND_SUB_MAX_COUNT[level];
                    }

                    subPercent = subPercent + (Argos.SECOND_SUB_PERCENT[level] * sub_count);
                    if(subPercent > Argos.BASIC_ENHANCE_PERCENT[level]) {
                        subPercent = Argos.BASIC_ENHANCE_PERCENT[level];
                    }
                    System.out.println("태양의 은총을 " + sub_count + "개 넣은 강화 확률 : " + ((percent + subPercent) / 100) + "%");

                    System.out.println("태양의 가호은 몇 개? : ");
                    System.out.println("최대 " +
                            Math.min(
                                    Argos.THIRD_SUB_MAX_COUNT[level],
                                    (int) (((double) (Argos.BASIC_ENHANCE_PERCENT[level] - subPercent) / Argos.THIRD_SUB_PERCENT[level]) + 0.99)
                            ) + "개 넣을 수 있어.");
                    sub_count = scanner.nextInt();

                    if(sub_count > Argos.THIRD_SUB_MAX_COUNT[level]) {
                        System.out.println("너무 많이 넣었어. 최대값으로 넣을게.");
                        sub_count = Argos.THIRD_SUB_MAX_COUNT[level];
                    }
                    subPercent = subPercent + (Argos.THIRD_SUB_PERCENT[level] * sub_count);
                    if(subPercent > Argos.BASIC_ENHANCE_PERCENT[level]) {
                        subPercent = Argos.BASIC_ENHANCE_PERCENT[level];
                    }
                    System.out.println("태양의 가호를 " + sub_count + "개 넣은 강화 확률 : " + ((percent + subPercent) / 100) + "%");

                    if(equip.argos_try_enhance(level, percent + subPercent)) {
                        System.out.println(enhance_count + "번째에 강화에 성공했어. 장인의 기운은 " + equip.getJanggibeak() + "%야.");
                        flag = false;
                    } else {
                        System.out.println("강화에 실패했어. 장인의 기운은 " + equip.getJanggibeak() + "%야.");
                        enhance_count++;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    }
}