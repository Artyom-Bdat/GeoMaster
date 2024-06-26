package com.example.tyomo_prodaqshn.lider_bord;// LeaderboardUtil.java

import com.example.tyomo_prodaqshn.model.users_models.UserModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderboardUtil {

    public static void sortByBal(List<UserModel> userList) {
        // Используем Comparator для сравнения по количеству баллов (bal)
        Collections.sort(userList, new Comparator<UserModel>() {
            @Override
            public int compare(UserModel user1, UserModel user2) {
                // Сравниваем баллы в обратном порядке (от большего к меньшему)
                return Integer.compare(user2.getBal(), user1.getBal());
            }
        });
    }
}
