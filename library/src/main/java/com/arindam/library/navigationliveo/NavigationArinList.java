
package com.arindam.library.navigationliveo;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.arindam.library.Model.HelpItem;
import com.arindam.library.Model.Navigation;
import com.arindam.library.R;
import com.arindam.library.adapter.NavigationArinItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class NavigationArinList {

    public static List<NavigationArinItemAdapter> getNavigationAdapter(Context context, Navigation navigation) {

        List<NavigationArinItemAdapter> mList = new ArrayList<>();
        if (navigation.nameItem == null || navigation.nameItem.size() == 0) {
            throw new RuntimeException(context.getString(R.string.list_null_or_empty));
        }

        int icon;
        int count;
        boolean isHeader;

        for (int i = 0; i < navigation.nameItem.size(); i++) {

            String title = navigation.nameItem.get(i);

            NavigationArinItemAdapter mItemAdapter;

            icon = (navigation.iconItem != null ? navigation.iconItem.get(i) : 0);
            isHeader = (navigation.headerItem != null && navigation.headerItem.contains(i));
            count = (navigation.countItem != null ? navigation.countItem.get(i, -1) : -1);

            boolean isVisible = false;
            if(navigation.hideItem != null){
                isVisible = navigation.hideItem.contains(i);
            }

            if (isHeader && icon > 0){
                throw new RuntimeException(context.getString(R.string.value_icon_should_be_0));
            }

            if (!isHeader) {
                if (title == null) {
                    throw new RuntimeException(context.getString(R.string.enter_item_name_position) + i);
                }

                if (title.trim().equals("")) {
                    throw new RuntimeException(context.getString(R.string.enter_item_name_position) + i);
                }
            }else{
                if (title == null) {
                    title = "";
                }

                if (title.trim().equals("")) {
                    title = "";
                }
            }

            mItemAdapter = new NavigationArinItemAdapter(title, icon, isHeader, count, navigation.colorSelected, navigation.removeSelector, !isVisible);
            mList.add(mItemAdapter);
        }
        return mList;
    }

    public static List<NavigationArinItemAdapter> getNavigationAdapter(Context context, List<HelpItem> listHelpItem, int colorSelected, boolean removeSelector) {

        List<NavigationArinItemAdapter> mList = new ArrayList<>();
        if (listHelpItem == null || listHelpItem.size() == 0) {
            throw new RuntimeException(context.getString(R.string.list_null_or_empty));
        }

        int icon;
        Drawable dIcon=null;
        int count;
        boolean isHeader;

        for (int i = 0; i < listHelpItem.size(); i++) {

            String title = listHelpItem.get(i).getName();

            NavigationArinItemAdapter mItemAdapter;

            icon = listHelpItem.get(i).getIcon();
            if(icon == 0) {
                dIcon = listHelpItem.get(i).getDrawableIcon();
            }
            isHeader = listHelpItem.get(i).isHeader();
            count = listHelpItem.get(i).getCounter();

            boolean isVisible = listHelpItem.get(i).isHide();

            if (isHeader && icon > 0){
                throw new RuntimeException(context.getString(R.string.value_icon_should_be_0));
            }

            if (!isHeader) {
                if (title == null) {
                    throw new RuntimeException(context.getString(R.string.enter_item_name_position) + i);
                }

                if (title.trim().equals("")) {
                    throw new RuntimeException(context.getString(R.string.enter_item_name_position) + i);
                }
            }else{
                if (title == null) {
                    title = "";
                }

                if (title.trim().equals("")) {
                    title = "";
                }
            }

            if(icon!=0)
                mItemAdapter = new NavigationArinItemAdapter(title, icon, isHeader, count, colorSelected, removeSelector, !isVisible);
            else
                mItemAdapter = new NavigationArinItemAdapter(title, dIcon, isHeader, count, colorSelected, removeSelector, !isVisible);
            mList.add(mItemAdapter);
        }
        return mList;
    }
}
