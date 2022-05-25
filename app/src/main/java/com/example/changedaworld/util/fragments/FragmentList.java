package com.example.changedaworld.util.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.changedaworld.R;
import com.example.changedaworld.util.LinkAdapter;
import com.example.changedaworld.util.UsefulLink;

import java.util.ArrayList;


public class FragmentList extends Fragment {

    public interface OnFragmentSendDataListener {
        void onSendData(String data);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    ArrayList<UsefulLink> links = new ArrayList<UsefulLink>();
    //ListView recipesList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        // получаем элемент ListView
        //ListView recipeList = view.findViewById(R.id.recipesList);
        setInitialData();
        //recipesList = getView().findViewById(R.id.recipesList);
        ListView linksList = view.findViewById(R.id.linksList);
        // создаем адаптер
        LinkAdapter adapter = new LinkAdapter(getContext(),R.layout.list_item, links);
        // устанавливаем для списка адаптер
        linksList.setAdapter(adapter);
        // добавляем для списка слушатель
        linksList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
//                Food selectedState = (Food)parent.getItemAtPosition(position);
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedState.getLink()));
//                startActivity(browserIntent);

                // получаем выбранный элемент
                UsefulLink selectedItem = (UsefulLink) parent.getItemAtPosition(position);
                // Посылаем данные Activity
                fragmentSendDataListener.onSendData(selectedItem.getLink());
            }
        });
        return view;
    }

    private void setInitialData(){
        links.add(new UsefulLink ("ByMath", "http://www.bymath.net/", R.drawable.bymath));
        links.add(new UsefulLink ("EasyMath", "http://www.easymath.com.ua/", R.drawable.easymath));
        links.add(new UsefulLink ("Арбуз", "http://arbuz.uz/", R.drawable.arbuz));
        links.add(new UsefulLink ("Мат. этюды", "https://etudes.ru/", R.drawable.etudes));
        links.add(new UsefulLink ("Решение задач онлайн", "https://www.math-solution.ru/", R.drawable.solution));
    }
}