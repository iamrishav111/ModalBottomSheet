
package iamrishav.bottomsheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    private List<String> mItems;
    private ItemListener mListener;

    ItemAdapter(List<String> items, ItemListener listener) {
        mItems = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bottom_sheet_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         String input=mItems.get(position);
        holder.setData(input);


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        String item;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        void setData(String item) {
            this.item = item;
            textView.setText(item);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    interface ItemListener {
        void onItemClick(String item);
    }
}
