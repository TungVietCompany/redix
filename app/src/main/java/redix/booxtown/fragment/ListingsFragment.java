package redix.booxtown.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import redix.booxtown.R;
import redix.booxtown.activity.ListingCollectionActivity;
import redix.booxtown.activity.ListingsDetailActivity;
import redix.booxtown.activity.MenuActivity;
import redix.booxtown.adapter.AdapterListings;
import redix.booxtown.adapter.ListBookAdapter;
import redix.booxtown.controller.BookController;
import redix.booxtown.controller.UserController;
import redix.booxtown.custom.MenuBottomCustom;
import redix.booxtown.model.Book;
import redix.booxtown.model.Explore;

/**
 * Created by Administrator on 29/08/2016.
 */
public class ListingsFragment extends Fragment
{
    ArrayList<Book> listEx= new ArrayList<>();
    GridView grid;
    Book book;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.listings_fragment, container, false);

        ImageView imageView_back=(ImageView) getActivity().findViewById(R.id.img_menu);
        Picasso.with(getContext()).load(R.drawable.btn_menu_locate).into(imageView_back);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MenuActivity.class);
                startActivity(intent);
            }
        });

        ImageView btn_filter_explore = (ImageView)view.findViewById(R.id.btn_filter_explore);
        Picasso.with(getContext()).load(R.drawable.btn_locate_filter).into(btn_filter_explore);

        ImageView btn_search = (ImageView)view.findViewById(R.id.btn_search);
        Picasso.with(getContext()).load(R.drawable.btn_locate_search).into(btn_search);

        //------------------------------------------------------------
        //add book
        TextView txt_add_book = (TextView)view.findViewById(R.id.txt_add_book);
        txt_add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("activity","add");
//                bundle.putSerializable("book",book);
                ListingCollectionActivity listingCollectionActivity = new ListingCollectionActivity();
                listingCollectionActivity.setArguments(bundle);
                callFragment(listingCollectionActivity);
            }
        });
        //-------------------------------------------------------------

        listingAsync listBook = new listingAsync(getContext());
        SharedPreferences pref = getActivity().getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor  = pref.edit();
        String session_id = pref.getString("session_id", null);
        listBook.execute(session_id);
        List<Book> list=listBook.listbook;
        Book e1= new Book();
        e1.setPrice("AED 300");
        e1.setAction("110");

        Book e2= new Book();
        e2.setPrice("AED 200");
        e2.setAction("101");

        Book e3= new Book();
        e3.setPrice("AED 200");
        e3.setAction("100");

        Book e4= new Book();
        e4.setPrice("AED 200");
        e4.setAction("111");

        listEx.add(e1);
        listEx.add(e2);
        listEx.add(e3);
        listEx.add(e4);
        //-----------------------------------------------------------
        final ListBookAdapter adapter = new ListBookAdapter(getActivity(),listEx);
        grid=(GridView)view.findViewById(R.id.grid_view_listings);
        grid.setAdapter(adapter);

        //--------------------------------------------------------------
        //change color tab

        TextView txt_my_listings = (TextView)view.findViewById(R.id.txt_my_listings);
        txt_my_listings.setTextColor(getResources().getColor(R.color.color_text));
        txt_my_listings.setBackgroundColor(getResources().getColor(R.color.dot_light_screen1));

        txt_add_book.setTextColor(getResources().getColor(R.color.dot_light_screen1));
        txt_add_book.setBackgroundColor(getResources().getColor(R.color.color_text));
        //end
        return view;
    }


    public void callFragment(Fragment fragment ){
        FragmentManager manager = ((AppCompatActivity) getActivity()).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //Khi được goi, fragment truyền vào sẽ thay thế vào vị trí FrameLayout trong Activity chính
        transaction.replace(R.id.frame_main_all, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    class listingAsync extends AsyncTask<String,Void,List<Book>>{

        Context context;
        ProgressDialog dialog;
        List<Book> listbook;
        public listingAsync(Context context){
            this.context = context;
        }

        @Override
        protected List<Book> doInBackground(String... strings) {
            BookController bookController = new BookController();
            listbook = bookController.getAllBookById(strings[0]);
            return listbook;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(context);
            dialog.setMessage("Please wait...");
            dialog.setIndeterminate(true);
            dialog.show();
            listbook = new ArrayList<>();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            if (books == null){
                Toast.makeText(context,"khong co",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(context,"co"+books.size(),Toast.LENGTH_LONG).show();
            }
            super.onPostExecute(books);
        }
    }
}

