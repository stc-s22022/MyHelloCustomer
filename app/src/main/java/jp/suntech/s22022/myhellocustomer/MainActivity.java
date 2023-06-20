package jp.suntech.s22022.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btClick = findViewById(R.id.btClick);
        //リスナ・オブジェクトの用意
        HelloListener listener = new HelloListener();
        //ボタンにリスナを設定
        btClick.setOnClickListener(listener);

        //クリアボタンであるButtonオブジェクトを取得
        Button btNameClear = findViewById(R.id.btNameClear);
        //クリアボタンにリスナを設定
        btNameClear.setOnClickListener(listener);

        Button btHomeClear = findViewById(R.id.btHomeClear);
        btHomeClear.setOnClickListener(listener);
    }

    //ボタンをクリックした時のリスナクラス
    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view){
            //名前入力欄であるEditTextオブジェクトを取得
            EditText input = findViewById(R.id.etName);
            //メッセージを表示するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.tvOutput);

            EditText inputhome = findViewById(R.id.etHome);

            //タップされた画面部品のidのR値を取得
            int id = view.getId();
            //idのR値に応じて処理を分岐
            if(id==R.id.btClick){
                //入力された名前文字列を取得
                String inputStr = input.getText().toString();
                String inhome = inputhome.getText().toString();
                //メッセージを表示
                output.setText(inhome + "にお住いの" + inputStr + "さん、こんにちは！");
            }else if(id==R.id.btNameClear){
                //名前入力欄を空文字に設定
                input.setText("");
                //メッセージ表示欄を空文字に設定
                output.setText("");
            }else if(id==R.id.btHomeClear){
                inputhome.setText("");
                output.setText("");
            }
        }
    }
}