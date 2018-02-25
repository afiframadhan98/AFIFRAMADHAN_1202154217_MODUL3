package com.example.android.afiframadhan_1202154217_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Afif Ramadhan on 2/24/2018.
 */

public class ListAdapter extends
    RecyclerView.Adapter<ListAdapter.WordViewHolder>   {

    private final LinkedList<String> mTitleList;    // Mendeklarasikan LinkedList untuk menampung Title
    private final LinkedList<String> mSubTitleList;     // Mendeklarasikan LinkedList untuk menampung SubTitle
    private final LinkedList<Integer> mBackgroundList;  // Mendeklarasikan LinkedList untuk menampung Background
    private LayoutInflater mInflater;   // Membuat variabel LayoutInflater

    public ListAdapter(Context context, LinkedList<String> TitleList, LinkedList<String> SubTitleList, LinkedList<Integer> BackgroundList) {
        mInflater = LayoutInflater.from(context);   // Assign variabel dengan context parameter (yang berisi LinkedList)
        this.mTitleList = TitleList;        // Assign variabel dengan parameter
        this.mSubTitleList = SubTitleList;      // Assign variabel dengan parameter
        this.mBackgroundList = BackgroundList;      // Assign variabel dengan parameter
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item, parent, false);      // Membuat Object View yang diassign menggunakan LayoutInflater
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        final String mCurrentTitle = mTitleList.get(position);      // Mendapatkan position
        final String mCurrentSubTitle = mSubTitleList.get(position);    // Mendapatkan position
        final Integer mCurrentBackground = mBackgroundList.get(position);   // Mendapatkan position untuk background
        holder.titleItemView.setText(mCurrentTitle);        // Melakukan set Text pada View Title
        holder.subtitleItemView.setText(mCurrentSubTitle);      // Melakukan set Text pada View Subtitle
        holder.linearLayout.setBackgroundResource(mCurrentBackground);      // Melakukan set Background pada
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DetailActivity.class);
                intent.putExtra("Title",mCurrentTitle);         // Mengirimkan data Title ke Intent Detail Activity
                intent.putExtra("Background",mCurrentBackground);       // Mengirimkan data Background ke Intent Detail Activity
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleItemView, subtitleItemView;      // Deklarasi variabel TextView
        public final LinearLayout linearLayout;     // Deklarasi variabel LinearLayout
        final ListAdapter mAdapter;
        public WordViewHolder(View itemView, ListAdapter adapter) {
            super(itemView);
            titleItemView = (TextView) itemView.findViewById(R.id.title);       // Assign itemView dengan id Textview
            subtitleItemView = (TextView) itemView.findViewById(R.id.subTitle);     // Assign itemView dengan id Textview
            linearLayout = (LinearLayout)itemView.findViewById(R.id.listBackground);        // Assign itemView dengan id LinerLayout
            this.mAdapter = adapter;        // Set Adapter
        }
    }
}
