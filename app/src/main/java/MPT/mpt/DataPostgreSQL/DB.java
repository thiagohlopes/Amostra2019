package MPT.mpt.DataPostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DB extends _default implements  Runnable{

    private Connection connection;
    private String host = "192.168.56.1";
    private String db = "Flery";
    private int door = 5432;//2345
    private String user = "admwindows";
    private String password = "admwindows";
    private String url = "jdbc:postgresql://%s:%d/%s";

    public DB() {
        super();
        this.url = String.format(this.url,this.host, this.door, this.db);

        this.conecta();
        this.desconecta();
    }

    @Override
    public void run() {
        try{
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(this.url,this.user,this.password);
        }catch (Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }

    }

    private void conecta(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception e){
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void desconecta(){
        if (this.connection!= null){
            try{
                this.connection.close();
            }catch (Exception e){

            }finally {
                this.connection = null;
            }
        }
    }

    public ResultSet select(String query){
        this.run();
        ResultSet resultSet = null;
        try {
            resultSet = new executeDB(this.connection, query).execute().get();
        }catch (Exception e){
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return resultSet;
    }

    public ResultSet execute(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new executeDB(this.connection, query).execute().get();
        }catch (Exception e){
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return resultSet;
    }
}
