package voc.net.tools.zgirls_tool.egg;

/**
 * Package voc.net.tools.zgirls_tool.egg was
 * Created by Voc-夜芷冰 , Programmer of Xectorda
 * Copyright © 2020 Xectorda 版權所有
 */
public class ChristmasRandom {
    private static final java.util.Random RANDOM = new java.util.Random();

    public float getRandom(float lower, float upper) {
        float min = Math.min(lower, upper);
        float max = Math.max(lower, upper);
        return getRandom(max - min) + min;
    }

    public float getRandom(float upper) {
        return RANDOM.nextFloat() * upper;
    }

    public int getRandom(int upper) {
        return RANDOM.nextInt(upper);
    }

}
