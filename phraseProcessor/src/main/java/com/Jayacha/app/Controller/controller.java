package com.hemlata.app.Controller;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemlata.app.Model.Phrase;
import com.hemlata.app.Repository.PhraseRepo;

@Controller
public class controller {
	String word;
	//ApiCalls ap=new ApiCalls(); //create object of the ApiCall.java class to access methods inside it
	ApiCalls ap = new ApiCalls();
	@Autowired
	PhraseRepo repo;

	@GetMapping("/") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView WPgethome(ModelAndView modelAndView, Phrase inp) {
		modelAndView.addObject("inp", inp);
		modelAndView.setViewName("wordHome");
		return modelAndView;
	}

	@PostMapping("/WP") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView WPposthome(ModelAndView modelAndView, Phrase inp) {
		word = inp.getWord().toLowerCase();
		modelAndView.addObject("word", word);
		modelAndView.addObject("inp", inp);
		modelAndView.setViewName("wordHomePost");
		return modelAndView;
	}

	@GetMapping("/syns") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView synshome(ModelAndView modelAndView) throws IOException, InterruptedException {
		modelAndView.addObject("word", word);
		String synss = ap.synd(word);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> RecMap = mapper.readValue(synss, Map.class);
		//  Map<String, Object> slist=(Map<String, Object>) RecMap.get("synonyms");
		ArrayList<String> slist = (ArrayList<String>) RecMap.get("synonyms");
		modelAndView.addObject("slist", slist);
		modelAndView.setViewName("syns");
		return modelAndView;
	}

	@GetMapping("/ants") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView antshome(ModelAndView modelAndView) throws IOException, InterruptedException {
		modelAndView.addObject("word", word);
		String synss = ap.ants(word);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> RecMap = mapper.readValue(synss, Map.class);
		//  Map<String, Object> slist=(Map<String, Object>) RecMap.get("synonyms");
		ArrayList<String> alist = (ArrayList<String>) RecMap.get("antonyms");
		modelAndView.addObject("alist", alist);
		modelAndView.setViewName("ants");
		return modelAndView;
	}

	@GetMapping("/defs") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView defshome(ModelAndView modelAndView) throws IOException, InterruptedException {
		modelAndView.addObject("word", word);
		String synss = ap.defs(word);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> RecMap = mapper.readValue(synss, Map.class);
		//  Map<String, Object> slist=(Map<String, Object>) RecMap.get("synonyms");
		ArrayList<String> list = (ArrayList<String>) RecMap.get("definitions");
		Iterator dlistt = list.iterator(); //convert map to iterable object
		Iterable<Object> dlist = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(dlistt, 0), false).collect(Collectors.toList());

		modelAndView.addObject("dlist", dlist);

		modelAndView.setViewName("defs");
		return modelAndView;
	}

	@GetMapping("/egs") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView egshome(ModelAndView modelAndView) throws IOException, InterruptedException {
		modelAndView.addObject("word", word);
		String synss = ap.egs(word);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> RecMap = mapper.readValue(synss, Map.class);
		//  Map<String, Object> slist=(Map<String, Object>) RecMap.get("synonyms");
		ArrayList<String> list = (ArrayList<String>) RecMap.get("examples");
		Iterator elistt = list.iterator(); //convert map to iterable object
		Iterable<Object> elist = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(elistt, 0), false).collect(Collectors.toList());

		modelAndView.addObject("elist", elist);

		modelAndView.setViewName("egs");
		return modelAndView;
	}

	@GetMapping("/rhs") //it will display index.html file to the user whenever "/" request is made.
	public ModelAndView rhshome(ModelAndView modelAndView) throws IOException, InterruptedException {
		modelAndView.addObject("word", word);
		String synss = ap.rhs(word);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> RecMap = mapper.readValue(synss, Map.class);
		Map<String, Object> rhmap = (Map<String, Object>) RecMap.get("rhymes");
		ArrayList<String> list = (ArrayList<String>) rhmap.get("all");
		Iterator rlistt = list.iterator(); //convert map to iterable object
		Iterable<Object> rlist = (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(rlistt, 0), false).collect(Collectors.toList());

		modelAndView.addObject("rlist", rlist);

		modelAndView.setViewName("rhs");
		return modelAndView;
	}

}