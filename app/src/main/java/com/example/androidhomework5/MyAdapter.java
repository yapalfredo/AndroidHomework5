package com.example.androidhomework5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    LayoutInflater layoutInflater;
    MyAdapter myAdapter;
    String[] myStrings1;
    String[] myStrings2;
    String[] myStrings3;
    ArrayList<String> selectedCountries;
    Context context;

    // Provide a reference to the views for each data item
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;
        ImageView imageView;
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView, MyAdapter adapter) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.txtViewLayout1);
            textView2 = itemView.findViewById(R.id.txtViewLayout2);
            imageView = itemView.findViewById(R.id.imgViewLayout);
            checkBox = itemView.findViewById(R.id.checkBoxViewLayout);
            myAdapter = adapter;
        }
    }

    //Constructor
    public MyAdapter(Context context, String[] myDataset1, String[] myDataset2, String[] myDataset3, ArrayList<String> selectedCountries) {
        layoutInflater = LayoutInflater.from(context);
        myStrings1 = myDataset1;
        myStrings2 = myDataset2;
        myStrings3 = myDataset3;
        this.context = context;
        this.selectedCountries = selectedCountries;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View view = layoutInflater.inflate(R.layout.recyclerview_layout, parent, false);
        return new MyViewHolder(view,this);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // - get element from your data at this position
        // - replace the contents of the view with that element

        final String mCurrent1 = myStrings1[position];    //countries
        String mCurrent2 = myStrings2[position];    //countriesCapital
        String mCurrent3 = myStrings3[position];    //countriesFlag

        //Catching the id given in R.drawable folder given by the mCurrent3 (country flags)
        int resID = context.getApplicationContext().getResources().getIdentifier(mCurrent3,"drawable",context.getPackageName());
        //The assign that id to this drawable object
        Drawable drawable = context.getResources().getDrawable(resID);

        holder.textView1.setText(mCurrent1);         //set value of text view fields
        holder.textView2.setText(mCurrent2);
        holder.imageView.setImageDrawable(drawable); //assign the drawable to the image view

        //save the country name to ArrayList when checkbox is checked
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked() == true)
                {
                    selectedCountries.add(mCurrent1);
                }else
                {
                    selectedCountries.remove(mCurrent1);
                }
            }
        });
    }

    // Return the size of your data (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return myStrings1.length;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
