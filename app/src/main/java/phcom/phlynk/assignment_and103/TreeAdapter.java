package phcom.phlynk.assignment_and103;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TreeAdapter extends BaseAdapter {

    List<TreeModel> treeModelList;
    Context context;

    public TreeAdapter(Context context, List<TreeModel> treeModelList) {
        this.context = context;
        this.treeModelList = treeModelList;
    }

    @Override
    public int getCount() {
        return treeModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return treeModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_tree, parent, false);

        TextView tvID = rowView.findViewById(R.id.tvId);
        ImageView imgAvatar = rowView.findViewById(R.id.imgAvatar);
        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvQuantity = rowView.findViewById(R.id.tvQuantity);
        TextView tvPrice = rowView.findViewById(R.id.tvPrice);
        TextView tvStatus = rowView.findViewById(R.id.tvStatus);
        TextView tvDescription = rowView.findViewById(R.id.tvDescription);
        TextView tvIdDistributor = rowView.findViewById(R.id.tvIdDistributor);

        TreeModel tree = treeModelList.get(position);

        tvID.setText(String.valueOf(tree.getIdDistributor()));
        tvName.setText(tree.getName());
        tvQuantity.setText("Quantity: " + tree.getQuantity());
        tvPrice.setText("Price: $" + tree.getPrice());
        tvStatus.setText("Status: " + tree.getStatus());
        tvDescription.setText(tree.getDescription());
        tvIdDistributor.setText("Distributor ID: " + tree.getIdDistributor());



        return rowView;
    }
}
