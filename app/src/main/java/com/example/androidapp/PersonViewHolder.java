package com.example.androidapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private TextView personNameTextView;
    private long id;

    public PersonViewHolder(final View itemView) {
        super(itemView);
        personNameTextView = itemView.findViewById(R.id.text_view_name);
        personNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Context context = v.getContext();
                context.startActivity(ProfileActivity.getIntent(context, id));
            }
        });
    }

    public void bind(final Person person) {
        personNameTextView.setText(person.getName());
        id = person.getId();
    }
}
