/*******************************************************************************
 * Twitter Grapher
 * Copyright (C) 2012 guido
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package es.guido.twitter.graph;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.social.twitter.api.TwitterProfile;

/**
 * Recursive Twitter traverser
 * @author guido
 */
public class TwitterTraverser {
    private Set<String> ALREADY_TRAVERSED = new HashSet<String>();
    private final GraphBuilder builder;
    
    private final TwitterDecorator twitter;
    private final int maxDepth;
    private final String startingNode;
    
    public TwitterTraverser(String startingNode, int maxDepth) {
        this(startingNode, maxDepth, false);
    }
    
    public TwitterTraverser(String startingNode, int maxDepth, boolean localCache) {
        this.builder = new GraphBuilder();
        this.twitter = new TwitterDecorator(localCache);
        this.maxDepth = maxDepth;
        this.startingNode = startingNode;
    }
    
    public void traverse() {
        traverse(startingNode, 0, (List) java.util.Collections.emptyList()); // recursive algorithm
    }
    
    private void traverse(String node, int depth, List known_names) {
        System.out.println("Visit " + node);
        
        if (ALREADY_TRAVERSED.contains(node)) {
            System.out.println("Node already traversed " + node);
            return;
        }
        
        ALREADY_TRAVERSED.add(node);

        if (depth == maxDepth) {
            System.out.println("Max depth reached at " + node);
            return;
        }

        List<TwitterProfile> friends = twitter.getFriends(node);
        System.out.println("\tFriends for " + node + " / depth = " + depth + " / request count = " + twitter.getRequestCount());
        
        for (TwitterProfile friend : friends) {
            System.out.println(friend.getScreenName());
            if (depth == 0 || known_names.contains(friend)) {
                 builder.addDirectedRelation(node, friend.getScreenName());
                 traverse(friend.getScreenName(), depth + 1, friends);
            }
        }
            
        System.out.println("End " + node + " / depth = " + depth);
    }
    
    public void export(String format, String fileName) throws IOException {
        System.out.println("Exporting as " + format + " to " + fileName);
        FileOutputStream fos = new FileOutputStream(fileName);
        builder.export(format, fos);
    }
}
