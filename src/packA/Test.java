/**
 * This exaple is an example of both modules and http2 client; Using module
 * concept we are implementing a http2 client to send some http request and
 * process the httpresponse
 *
 * @author bada
 *
 */
package packA;

import java.net.URI;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpHeaders;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class Test {
	public static void main(String[] args) throws Exception {
		String url = "https://www.redbus.in/info/aboutus";
		sendGetSyncRequest(url);
		sendGetAsyncRequest(url);
	}

	public static void sendGetSyncRequest(String url) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder(new URI(url)).GET().build();
		HttpResponse resp = client.send(req, HttpResponse.BodyHandler.asFile(Paths.get("sync.html")));
		processResponse(resp);
	}

	public static void processResponse(HttpResponse resp) {
		System.out.println("Status Code:" + resp.statusCode());
		// System.out.println("Response Body:"+resp.body());
		HttpHeaders header = resp.headers();
		Map<String, List<String>> map = header.map();
		System.out.println("Response Headers");
		map.forEach((k, v) -> System.out.println("\t" + k + ":" + v));
	}

	public static void sendGetAsyncRequest(String url) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder(new URI(url)).GET().build();
		System.out.println("Sending Asynchronous Request...");
		CompletableFuture<HttpResponse<String>> cf = client.sendAsync(req, HttpResponse.BodyHandler.asString());
		int count = 0;
		while (!cf.isDone()) {
			System.out.println("Processing not done and doing other activity:" + ++count);
		}
		processResponse(cf.get());
	}
}
