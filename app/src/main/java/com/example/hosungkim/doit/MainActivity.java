package com.example.hosungkim.doit;

import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Person> m_orders = new ArrayList<Person>();

        Person p1 = new Person("안드로이드", "안드로이드");
        Person p2 = new Person("구글", "02-123-4567");
        Person p3 = new Person("건국대학교", "건국대학교");
        Person p4 = new Person("일급", "30000");
        m_orders.add(p1);
// 리스트에 객체를 추가
        m_orders.add(p2);
        m_orders.add(p3);
        m_orders.add(p4);
        PersonAdapter m_adapter = new PersonAdapter(this, R.layout.row, m_orders);
// 어댑터를 생성
        setListAdapter(m_adapter);


    }

    private class PersonAdapter extends ArrayAdapter<Person> {

        private ArrayList<Person> items;

        public PersonAdapter(Context context, int textViewResourceId, ArrayList<Person> items) {
            super(context, textViewResourceId, items);
            this.items = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.row, null);
            }
            Person p = items.get(position);
            if (p != null) {
                TextView tt = (TextView) v.findViewById(R.id.onetext);
                TextView bt = (TextView) v.findViewById(R.id.twotext);
                TextView sk = (TextView) v.findViewById(R.id.threetext);
                TextView ct = (TextView) v.findViewById(R.id.fourtext);
                if (tt != null) {
                    tt.setText(p.getName());
                }
                if (bt != null) {
                    bt.setText(p.getNumber());
                }

                if (sk != null) {
                    sk.setText(p.getUniv());
                }
                if (ct != null) {
                    ct.setText(p.getPay());
                }
            }
            return v;
        }
    }

    class Person {

        private String Name;
        private String Number;
        private String Univ;
        private String Pay;

        public Person(String _Name, String _Number, String _Univ, String _Pay) {
            this.Name = _Name;
            this.Number = _Number;
            this.Univ = _Univ;
            this.Pay = _Pay;
        }

        public String getName() {
            return Name;
        }

        public String getNumber() {
            return Number;
        }

        public String getUniv() {
            return Univ;
        }

        public String getPay() {
            return Pay;
        }
    }
}
