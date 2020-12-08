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
        switch (password.getIdentifyer()) {
            case "Twitter":
                holder.app_logo.setImageResource(R.drawable.twitter);
                break;
            case "Instagram":
                holder.app_logo.setImageResource(R.drawable.instagram);
                break;
            case "Facebook":
                holder.app_logo.setImageResource(R.drawable.facebook);
                break;
            case "Google":
                holder.app_logo.setImageResource(R.drawable.google);
                break;
            case "Outlook":
                holder.app_logo.setImageResource(R.drawable.outlook);
                break;
            case "Protonmail":
                holder.app_logo.setImageResource(R.drawable.protonmail);
                break;
            case "Tumblr":
                holder.app_logo.setImageResource(R.drawable.tumblr);
                break;
            case "Pinterest":
                holder.app_logo.setImageResource(R.drawable.pinterest);
                break;
            case "LinkedIn":
                holder.app_logo.setImageResource(R.drawable.linkedin);
                break;
            case "Reddit":
                holder.app_logo.setImageResource(R.drawable.reddit);
                break;
            case "Spotify":
                holder.app_logo.setImageResource(R.drawable.spotify);
                break;
            case "Netflix":
                holder.app_logo.setImageResource(R.drawable.netflix);
                break;
            case "Amazon":
                holder.app_logo.setImageResource(R.drawable.amazon);
                break;
            case "HBO":
                holder.app_logo.setImageResource(R.drawable.hbo);
                break;
            default:
                holder.app_logo.setImageResource(R.drawable.other);
                break;
        }
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

        ImageView app_logo;
        TextView identifyer, username, password;
        OnPasswordListener onPasswordListener;

        public ViewHolder(@NonNull View itemView, OnPasswordListener onPasswordListener) {
            super(itemView);
            app_logo = (ImageView) itemView.findViewById(R.id.app_logo);
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
