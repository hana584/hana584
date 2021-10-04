import 'package:flutter/material.dart';
import 'dart:math';
void main() => runApp(
      MaterialApp(
        home: Scaffold(
          backgroundColor: Colors.black87,
          appBar: AppBar(
            title: Text('Ask Me Anything'),
            backgroundColor: Colors.blue,

          ),
          body: BallPage(),
        )
      ),
    );
class BallPage extends StatefulWidget {
  

  @override
  _BallPageState createState() => _BallPageState();
}
int num=1;
class _BallPageState extends State<BallPage> {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Row(
children: <Widget>[

Expanded(
  child:FlatButton(
    onPressed: (){
      setState(() {
        num=Random().nextInt(5)+1;
      });
      
    },
    child: Image.asset('images/ball$num.png')
    )
   )
],
      ),
    );
  }
}