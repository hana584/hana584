
import 'package:flutter/material.dart';

import 'emg.dart';
import 'eeg.dart';
import 'login_page.dart';


class HomePage extends StatelessWidget {
  static String tag= 'home-page';

  @override
  Widget build(BuildContext context) {
   final logo =Hero(tag: 'hero', child: CircleAvatar(
      backgroundColor: Colors.transparent,
      radius: 100.0,
      child:Image.asset('assets/robo.jpg',),
    ),

    );
    
    final ttext = Padding(
        padding: EdgeInsets.all(30),
        child: Text(
          'Please choose which Signal you desire to control your ROBO arm with.',
          textAlign: TextAlign.start,
          style: TextStyle(fontSize:20,color: Colors.brown.shade900),
        ),
    );
    final emg = Padding(
      padding: EdgeInsets.symmetric(vertical: 16.0),
      child: RaisedButton(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(24),

        ),
        onPressed: (){
           Navigator.push
        (
            context,
            MaterialPageRoute(builder: (context)
        {
          return new Emg();
        })


);
        },
        padding: EdgeInsets.all(12),
        color: Colors.orange.shade100,
        child:Text('EMG Signals',style:TextStyle(color:Colors.brown.shade900,fontSize: 36)),
      ),

    );
    final eeg = Padding(
      padding: EdgeInsets.symmetric(vertical: 20.0),
      child: RaisedButton(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(24),

        ),
        onPressed: (){
           Navigator.push
        (
            context,
            MaterialPageRoute(builder: (context)
        {
          return new Eeg();
        })


);
        },
        padding: EdgeInsets.all(20),
        color: Colors.orange.shade100,
        child:Text('EEG Signals',style:TextStyle(color:Colors.brown.shade900,fontSize: 36)),
      ),

    );
    final log_out = FlatButton(
      child: Text(
        'Log Out',
        style:TextStyle(color: Colors.red,fontSize: 25),
        
      ),
      onPressed: () {
        Navigator.push
        (
            context,
            MaterialPageRoute(builder: (context)
        {
          return new LoginPage();
        })


);

      },
    );
     return Scaffold(
      backgroundColor: Colors.white,
      body: Center(
        child: ListView(
          shrinkWrap: true,
          padding: EdgeInsets.only(left: 24.0,right: 24.0),
          children:<Widget>[
            ttext,
            
            emg,
            eeg,
            SizedBox(height: 40.0),
            log_out


          ],
        ),
      ),
    );

  }
}