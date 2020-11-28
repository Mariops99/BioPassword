package com.marioprieto.biopassword;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PasswordAdapter extends RecyclerView.Adapter<PasswordAdapter.ViewHolder> {

    public ArrayList<Password> passwords = new ArrayList<>();
    private Context context;
    private OnPasswordListener mOnPasswordListener;

    public PasswordAdapter(Context context, OnPasswordListener onPasswordListener) {
        this.context = context;
        this.mOnPasswordListener = onPasswordListener;
    }


    @NonNull
    @Override
    public PasswordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_password, parent, false);
        return new ViewHolder(view, mOnPasswordListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PasswordAdapter.ViewHolder holder, int position) {
        Password password = passwords.get(position);
        holder.identifyer.setText(password.getIdentifyer());
        holder.username.setText(password.getUsername());
        holder.password.setText(password.getPassword());

    }

    @Override
    public int getItemCount() {
        return passwords.size();
    }

    public void addPasswords(ArrayList<Password> finalPassword) {
        passwords.addAll(finalPassword);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView identifyer, username, password;
        OnPasswordListener onPasswordListener;

        public ViewHolder(@NonNull View itemView, OnPasswordListener onPasswordListener) {
            super(itemView);
            identifyer = (TextView) itemView.findViewById(R.id.identifyer);
            username = (TextView) itemView.findViewById(R.id.username);
            password = (TextView) itemView.findViewById(R.id.password);
            this.onPasswordListener = onPasswordListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onPasswordListener.onPasswordClick(getAdapterPosition());
        }
    }

    public void removePasswords() {

    }

    public interface OnPasswordListener {
        void  onPasswordClick(int position);
    }
}
