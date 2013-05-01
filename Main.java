/*
* A simple programme to download towel.blinkenlights.nl ASCII animation as text file
* GitHub - https://github.com/anjanborah/Download_towel_blinkenlights_nl
* Author - Anjan Borah
* Copyright ( c ) 2013 Anjan Borah
*/

import java.net.Socket;
import java.io.InputStream;
import java.io.FileOutputStream;

public class Main {
  public static void main( String args[] ) {
    Download object = new Download();
  }
}

class Download {
  public Download()  {
    try {
      this.start_downloader();
    } catch( Exception exception ) {
      System.out.println( "Exception - " + exception.toString() );
      System.exit( 0 );
    }
  }
  
  private void start_downloader() {
    try {
      this.socket = new Socket( "towel.blinkenlights.nl", 23 );
      this.input_stream = this.socket.getInputStream();
      this.output_stream = new FileOutputStream( "animation.txt" );
      int read = this.input_stream.read();
      while( read != -1 ) {
        System.out.write( read );
        read = this.input_stream.read();
        output_stream.write( read );
      }
      this.input_stream.close();
      this.output_stream.close();
    } catch( Exception exception ) {
      System.out.println( "Exception - " + exception );
      System.exit( 0 );
    }
  }
  
  private Socket socket;
  private InputStream input_stream;
  private FileOutputStream output_stream;
}
