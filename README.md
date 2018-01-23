# Twitter friends graph in Java/Spring with Gephi

This Java web application creates a network graph of friends for any Twitter user.


## Try it out

Add a Twitter user's name to the app url. Try the examples below:
(Warning: due to Twitter's rate limit restrictions, it only works *once every 15 minutes*.)

- [http://nfio.co.nf/gexf-js/#https://tth-rdm.herokuapp.com/rogerfederer](http://nfio.co.nf/gexf-js/#https://tth-rdm.herokuapp.com/rogerfederer)
- [http://nfio.co.nf/gexf-js/#https://tth-rdm.herokuapp.com/rafaelnadal](http://nfio.co.nf/gexf-js/#https://tth-rdm.herokuapp.com/rafaelnadal)
- [http://nfio.co.nf/gexf-js/#https://tth-rdm.herokuapp.com/brunomars](http://nfio.co.nf/gexf-js/#https://tth-rdm.herokuapp.com/brunomars)
et cetera...

You can replace the names above with any Twitter user's username.

<img src="https://image.ibb.co/g0GAWw/roger_federer_twitter.png" alt="roger federer twitter" border="0" width="70%" />

## How it works


The Twitter crawler was created using [palmerabollo](https://github.com/palmerabollo)'s [Twitter test graph](https://github.com/palmerabollo/test-twitter-graph) as a starting point. The graph is put together using [Gephi](https://gephi.org/), exported in the XML-based gexf format, then returned as a HTTP response. 
You can see the XML if you visit the Java web application directly, such as:

[https://tth-rdm.herokuapp.com/rafaelnadal](https://tth-rdm.herokuapp.com/rafaelnadal)

Thanks to [Raphaël Velt](https://github.com/raphv) for creating a useful [gexf viewer](https://github.com/raphv/gexf-js) in Javascript. I've used it in the above links to turn the XML into a nice graph.

## Run the code

On your own server:
1. Set up Tomcat and Java environment.
2. Create environment variables to store your Twitter keys:
    - `export ACCESS_SECRET="your access secret"`
    - `export ACCESS_TOKEN="your access token"`
    - `export CONSUMER_KEY="your consumer key"`
    - `export CONSUMER_SECRET="your consumer secret"`

Or, using Heroku:
1. Deploy to Heroku

    [![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

2. Add environment variables using the dashboard, or Heroku CLI:
    - `heroku config:set ACCESS_SECRET="your access secret"`
    - `heroku config:set ACCESS_TOKEN="your access token"`
    - `heroku config:set CONSUMER_KEY="your consumer key"`
    - `heroku config:set CONSUMER_SECRET="your consumer secret"`
