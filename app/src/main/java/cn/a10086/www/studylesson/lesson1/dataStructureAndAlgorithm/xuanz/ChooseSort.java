package cn.a10086.www.studylesson.lesson1.dataStructureAndAlgorithm.xuanz;

import java.util.Arrays;

import cn.a10086.www.studylesson.lesson1.dataStructureAndAlgorithm.SortUtils;

/**
 * @author
 * @time 2017/3/20  15:48
 * @desc ${TODD}
 */
public class ChooseSort {

    /**
     * 选择排序。   一个位置 L与所有的位置All_L，一次进行对比 和交换。
     * 一轮对比完，那个位置的值既最小
     * 时间复杂度  O(n²) 。 (n-1)次循环*(n)次循环
     */
    public static void main(String[] args) {

//        第一层循环确定L的位置
        for (int i = 0; i < SortUtils.sort.length - 1; i++) {
            //All_L 的的循环。需要在位置L的后边开始
             //从后面的一个数开始排序的
            for (int j = i + 1; j < SortUtils.sort.length; j++) {
                SortUtils.rightBig(SortUtils.sort, i, j);

            }
            System.out.println("value1:" + Arrays.asList(SortUtils.sort));


        }
//        System.out.println("value:" + Arrays.asList(SortUtils.sort));


    }
}
