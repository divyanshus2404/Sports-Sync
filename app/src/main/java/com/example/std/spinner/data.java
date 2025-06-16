package com.example.std.spinner;


import com.example.std.R;
import java.util.ArrayList;
import java.util.List;

    public class data {

        public static List<Fruit> getFruitList() {
            List<Fruit> fruitList = new ArrayList<>();

            Fruit Avocado = new Fruit();
            Avocado.setName("Cricket");
            Avocado.setImage(R.drawable.cricket_bat);
            fruitList.add(Avocado);

            Fruit Banana = new Fruit();
            Banana.setName("Football");
            Banana.setImage(R.drawable.ftbal);
            fruitList.add(Banana);

            Fruit Coconut = new Fruit();
            Coconut.setName("Hockey");
            Coconut.setImage(R.drawable.hockey);
            fruitList.add(Coconut);

            Fruit Guava = new Fruit();
            Guava.setName("TableTennis");
            Guava.setImage(R.drawable.tabletennis);
            fruitList.add(Guava);

            Fruit Lemon = new Fruit();
            Lemon.setName("VolleyBall");
            Lemon.setImage(R.drawable.volleyball);
            fruitList.add(Lemon);

            Fruit Mango = new Fruit();
            Mango.setName("Snooker");
            Mango.setImage(R.drawable.snooker);
            fruitList.add(Mango);

            Fruit Orange = new Fruit();
            Orange.setName("LawnTennis");
            Orange.setImage(R.drawable.lawntennis);
            fruitList.add(Orange);

            return fruitList;
        }

    }

