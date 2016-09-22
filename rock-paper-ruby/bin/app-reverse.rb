require 'sinatra'

set :port, 8080
set :static, true
set :public_folder, "static"
set :views, "views"

# set up response type and an array of viable moves
before do
    content_type :txt
    @defeat = {rock: :scissors, paper: :rock, scissors: :paper}
    @throws = @defeat.keys
end

get '/' do
    return 'Hello World'
end

get '/hello/' do
    erb :hello_form
end

post '/hello/' do
    greeting = params[:greeting] || "Hi There"
    name = params[:name] || "Nobody"

    erb :index, :locals => {'greeting' => greeting, 'name' => name}
end

get '/throw/:type' do

    player_throw = params[:type].to_sym

    # if player throw is invalid
    unless @throws.include?(player_throw)
        halt 403, "You must throw one of the following: #{@throws}"
    end
    
    computer_throw = @throws.sample

    # compare the player and computer throws to declare a winner
    if player_throw == computer_throw
        "You tied with the computer. Try again!"
    elsif computer_throw == @defeat[player_throw]
        "Nicely done; #{params[:type].reverse} beats #{computer_throw}!"
    else
        "Ouch; #{computer_throw} beats #{params[:type].reverse}. Better luck next time!"
    end

end 



